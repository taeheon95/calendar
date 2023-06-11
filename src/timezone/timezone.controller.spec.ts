import { TestingModule } from '@nestjs/testing';
import { TimezoneController } from './timezone.controller';
import Timezone from './model/Timezone.entity';
import { TimezoneService } from './timezone.service';
import { createDefaultTestingModule } from 'src/util/test.util';

describe('TimezoneController', () => {
  let controller: TimezoneController;

  beforeEach(async () => {
    const module: TestingModule = await createDefaultTestingModule({
      providers: [TimezoneService],
      entities: [Timezone],
      controllers: [TimezoneController],
    });

    controller = module.get<TimezoneController>(TimezoneController);
  });

  it('should be defined', () => {
    expect(controller).toBeDefined();
  });
});
