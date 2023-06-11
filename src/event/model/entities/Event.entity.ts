import { Column, Entity, OneToMany, PrimaryGeneratedColumn } from 'typeorm';
import EventLocation from './EventLocation.entity';
import EventDateTime from './EventDateTime.entity';
import EventAttendant from './EventAttendant.entity';
import EventReminder from './EventReminder.entity';

@Entity({
  name: 't_event',
})
class Event {
  @PrimaryGeneratedColumn()
  eventNo: number;

  @Column({ length: 100 })
  summary: string;

  @Column(() => EventDateTime)
  start: EventDateTime;

  @Column(() => EventDateTime)
  end: EventDateTime;

  @Column({
    length: 50,
  })
  timezone: string;

  @Column()
  repeatRule?: string;

  @Column({ default: false })
  allDay: boolean;

  @Column({
    length: 2000,
  })
  description?: string;

  @Column(() => EventLocation)
  location?: EventLocation;

  @OneToMany(() => EventAttendant, (attendant) => attendant.event, {
    lazy: true,
  })
  attendantList: EventAttendant[];

  @OneToMany(() => EventReminder, (reminder) => reminder.event, {
    lazy: true,
  })
  reminderList: EventReminder[];
}

export default Event;
