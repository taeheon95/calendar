import { Test, TestingModule } from '@nestjs/testing';
import { TypeOrmModule } from '@nestjs/typeorm';
import { TimezoneController } from './timezone.controller';
import { AppModule } from '../app.module';
import Timezone from './model/Timezone.entity';
import { TimezoneService } from './timezone.service';

describe('TimezoneController', () => {
  let controller: TimezoneController;

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      imports: [AppModule, TypeOrmModule.forFeature([Timezone])],
      controllers: [TimezoneController],
      providers: [TimezoneService],
    }).compile();

    controller = module.get<TimezoneController>(TimezoneController);
  });

  it('should be defined', () => {
    expect(controller).toBeDefined();
  });
});
