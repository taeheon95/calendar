import { DataSource } from 'typeorm';
import { newDb, DataType } from 'pg-mem';
import { v4 } from 'uuid';
import { Test, TestingModule } from '@nestjs/testing';
import {
  Abstract,
  DynamicModule,
  ForwardReference,
  Provider,
  Type,
} from '@nestjs/common';
import { TypeOrmModule } from '@nestjs/typeorm';

export const createDefaultTestingModule = async ({
  imports,
  providers,
  controllers,
  exports,
  entities,
}: {
  imports?: Array<DynamicModule | Promise<DynamicModule>>;
  providers?: Provider[];
  controllers?: Type<any>[];
  entities?: any[];
  exports?: Array<
    | DynamicModule
    | Promise<DynamicModule>
    | string
    | symbol
    | Provider
    | ForwardReference
    | Abstract<any>
  >;
}) => {
  const setupTestDataSource = async () => {
    const db = newDb({
      autoCreateForeignKeyIndices: true,
    });
    db.public.registerFunction({
      implementation: () => 'test',
      name: 'current_database',
    });

    db.registerExtension('uuid-ossp', (schema) => {
      schema.registerFunction({
        name: 'uuid_generate_v4',
        returns: DataType.uuid,
        implementation: v4,
        impure: true,
      });
    });

    db.public.registerFunction({
      name: 'version',
      implementation: () =>
        'PostgreSQL 14.2, compiled by Visual C++ build 1914, 64-bit',
    });

    const ds: DataSource = await db.adapters.createTypeormDataSource({
      type: 'postgres',
      database: 'calendar',
      entities: [`dist/**/*.entity{.ts,.js}`, 'src/**/*.entity{.ts,.js}'],
      host: 'localhost',
      port: 5432,
      username: 'test',
      password: 'test',
      migrationsRun: false,
      migrationsTransactionMode: 'each',
      synchronize: false,
    });
    await ds.initialize();
    await ds.synchronize();

    return ds;
  };

  const module: TestingModule = await Test.createTestingModule({
    imports: imports
      ? [
          TypeOrmModule.forRootAsync({
            useFactory: () => ({
              type: 'postgres',
              migrationsRun: false,
            }),
            dataSourceFactory: async () => await setupTestDataSource(),
          }),
          TypeOrmModule.forFeature(entities ? entities : []),
          ...imports,
        ]
      : [
          TypeOrmModule.forRootAsync({
            useFactory: () => ({
              type: 'postgres',
              migrationsRun: false,
            }),
            dataSourceFactory: async () => await setupTestDataSource(),
          }),
          TypeOrmModule.forFeature(entities ? entities : []),
        ],
    controllers: controllers ? [...controllers] : [],
    providers: providers ? [...providers] : [],
    exports: exports ? [...exports] : [],
  }).compile();
  return module;
};

export const setupTestDataSource = async () => {
  const db = newDb({
    autoCreateForeignKeyIndices: true,
  });
  db.public.registerFunction({
    implementation: () => 'test',
    name: 'current_database',
  });

  db.registerExtension('uuid-ossp', (schema) => {
    schema.registerFunction({
      name: 'uuid_generate_v4',
      returns: DataType.uuid,
      implementation: v4,
      impure: true,
    });
  });

  db.public.registerFunction({
    name: 'version',
    implementation: () =>
      'PostgreSQL 14.2, compiled by Visual C++ build 1914, 64-bit',
  });

  const ds: DataSource = await db.adapters.createTypeormDataSource({
    type: 'postgres',
    database: 'calendar',
    entities: [`dist/**/*.entity{.ts,.js}`, 'src/**/*.entity{.ts,.js}'],
    host: 'localhost',
    port: 5432,
    username: 'test',
    password: 'test',
    migrationsRun: false,
    migrationsTransactionMode: 'each',
    synchronize: false,
  });
  await ds.initialize();
  await ds.synchronize();

  return ds;
};
