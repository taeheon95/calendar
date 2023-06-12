import { Test, TestingModule } from '@nestjs/testing';
import Timezone from './Timezone.entity';
import { createTimezoneSchema, updateTimezoneSchema } from './dto/Timezone.dto';

describe('timezone entity', () => {
  const seoulTimezone = {
    timezone: 'Asia/Seoul',
    description: 'Korea Standard Time',
    offset: 9,
  };
  const errorTimezone1 = {
    timezone: 'Asia/Seoul',
    description: null,
    offset: 0,
  };
  const errorTimezone2 = {
    timezone: 'Asia/Seoul',
    description: 'Korea Standard Time',
    offset: -13,
  };
  it('create timezone dto로 entity 생성하기', () => {
    const timezone = Timezone.createTimezone(seoulTimezone);
    expect(timezone.timezone).toBe(seoulTimezone.timezone);
    expect(timezone.offset).toBe(seoulTimezone.offset);
    expect(timezone.description).toBe(seoulTimezone.description);
  });
  it('update timezone dto로 entity 수정하기', () => {
    const timezone = Timezone.createTimezone(seoulTimezone);
    timezone.update({
      ...timezone,
      offset: 12,
    });
    expect(timezone.offset).toEqual(12);
  });
  it('schema error 생성하기 description 검증', () => {
    const result = createTimezoneSchema.validate(errorTimezone1);
    expect(result.error).toBeDefined();
  });

  it('error 생성하기 offset 검증', () => {
    const result = createTimezoneSchema.validate(errorTimezone2);
    const result2 = createTimezoneSchema.validate({
      timezone: 'Asia/Seoul',
      description: 'Korea Standard Time',
      offset: 13,
    });
    expect(result.error).toBeDefined();
    expect(result2.error).toBeDefined();
  });
});
