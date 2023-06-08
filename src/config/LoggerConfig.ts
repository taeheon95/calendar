import * as winston from 'winston';
import { WinstonModule, WinstonModuleOptions } from 'nest-winston';
import { ConfigService } from '@nestjs/config';

WinstonModule.forRoot({});

const winstonConfig: WinstonModuleOptions = {
  instance: winston.createLogger({}),
};
