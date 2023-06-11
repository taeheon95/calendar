import { Column } from 'typeorm';

class EventDateTime {
  @Column({
    type: 'int2',
  })
  year: number;

  @Column({
    type: 'int2',
  })
  month: number;

  @Column({
    type: 'int2',
  })
  day: number;

  @Column({
    type: 'int2',
    nullable: true,
  })
  hour?: number;

  @Column({
    type: 'int2',
    nullable: true,
  })
  minute?: number;
}

export default EventDateTime;
