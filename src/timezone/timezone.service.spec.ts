import { TestingModule } from '@nestjs/testing';
import { TimezoneService } from './timezone.service';
import Timezone from './model/Timezone.entity';
import { createDefaultTestingModule } from '../util/test.util';

describe('TimezoneService', () => {
  let service: TimezoneService;

  beforeEach(async () => {
    const module: TestingModule = await createDefaultTestingModule({
      providers: [TimezoneService],
      entities: [Timezone],
    });

    service = module.get<TimezoneService>(TimezoneService);
  });

  it('should be defined', () => {
    expect(service).toBeDefined();
  });
});
