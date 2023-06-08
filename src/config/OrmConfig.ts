import { TypeOrmModuleOptions } from '@nestjs/typeorm';
import { ConfigService } from '@nestjs/config';

export async function OrmConfig(
  configService: ConfigService,
): Promise<TypeOrmModuleOptions> {
  return {
    // eslint-disable-next-line @typescript-eslint/ban-ts-comment
    //@ts-ignore
    type: configService.get<string>('DB_TYPE'),
    host: configService.get<string>('DB_HOST'),
    port: configService.get<number>('DB_PORT'),
    username: configService.get<string>('DB_USER'),
    password: configService.get<string>('DB_PASSWORD'),
    database: 'calendar',
    entities: [`${__dirname}/**/*.entity{.ts,.js}`],
    synchronize: true,
  };
}
