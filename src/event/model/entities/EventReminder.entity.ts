import {
  Column,
  Entity,
  JoinColumn,
  ManyToOne,
  PrimaryGeneratedColumn,
} from 'typeorm';
import Event from './Event.entity';

enum ReminderMethod {
  EMAIL = 'EMAIL',
  POPUP = 'POPUP',
}

@Entity({
  name: 't_event_reminder',
})
class EventReminder {
  @PrimaryGeneratedColumn()
  reminderNo: number;

  @Column({ type: 'enum', enum: ReminderMethod })
  method: ReminderMethod;

  @Column()
  minutes: number;

  @ManyToOne(() => Event, (event) => event.reminderList, {
    onDelete: 'CASCADE',
  })
  @JoinColumn({ name: 'eventNo' })
  event: Event;
}

export default EventReminder;
