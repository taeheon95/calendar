import { Column, Entity, PrimaryGeneratedColumn } from 'typeorm';
import { CreateTimezoneDto, UpdateTimezoneDto } from './dto/Timezone.dto';

@Entity({
  name: 't_timezone',
})
class Timezone {
  @PrimaryGeneratedColumn()
  timezoneNo: number;

  @Column({
    unique: true,
  })
  timezone: string;

  @Column()
  description: string;

  @Column({
    type: 'int2',
  })
  offset: number;

  static createTimezone(createTimezoneDto: CreateTimezoneDto): Timezone {
    const timezone = new Timezone();
    timezone.timezone = createTimezoneDto.timezone;
    timezone.offset = createTimezoneDto.offset;
    timezone.description = createTimezoneDto.description;
    return timezone;
  }

  update(updateTimezoneDto: UpdateTimezoneDto) {
    this.timezone = updateTimezoneDto.timezone;
    this.description = updateTimezoneDto.description;
    this.offset = updateTimezoneDto.offset;
  }
}

export default Timezone;
