import { Test, TestingModule } from '@nestjs/testing';
import Timezone from './Timezone.entity';
import { createTimezoneSchema, updateTimezoneSchema } from './dto/Timezone.dto';

describe('timezone entity', () => {
  const seoulTimezone = {
    timezone: 'Asia/Seoul',
    description: 'Korea Standard Time',
    offset: 9,
  };
  it('create timezone dto로 생성하기', () => {
    createTimezoneSchema.validate(seoulTimezone);
  });
});
