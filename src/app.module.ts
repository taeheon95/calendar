import { Module } from '@nestjs/common';
import { AppController } from './app.controller';
import { AppService } from './app.service';
import { ConfigModule, ConfigService } from '@nestjs/config';
import { TypeOrmModule } from '@nestjs/typeorm';
import { UserModule } from './user/user.module';
import { CalendarModule } from './calendar/calendar.module';
import { OrmConfig } from './config/OrmConfig';
import { EventModule } from './event/event.module';
import { TimezoneModule } from './timezone/timezone.module';

@Module({
  imports: [
    ConfigModule.forRoot({
      isGlobal: true,
      envFilePath: `.env.${process.env.NODE_ENV}`,
    }),
    TypeOrmModule.forRootAsync({
      inject: [ConfigService],
      useFactory: async (configService: ConfigService) =>
        await OrmConfig(configService),
    }),
    UserModule,
    CalendarModule,
    EventModule,
    TimezoneModule,
  ],
  controllers: [AppController],
  providers: [AppService],
})
export class AppModule {}
