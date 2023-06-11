import {
  Column,
  Entity,
  JoinColumn,
  ManyToOne,
  PrimaryGeneratedColumn,
} from 'typeorm';
import Event from './Event.entity';

enum ATTENDANCE_STATUS {
  ACCEPTED = 'ACCEPTED',
  DECLINED = 'DECLINED',
  NEED_ANSWER = 'NEED_ANSWER',
}

@Entity({
  name: 't_event_attendant',
})
class EventAttendant {
  @PrimaryGeneratedColumn()
  attendantNo: number;

  @Column({ nullable: true })
  userNo?: string;

  @Column({ nullable: true })
  email?: string;

  @Column({ type: 'enum', enum: ATTENDANCE_STATUS })
  status: ATTENDANCE_STATUS;

  @ManyToOne(() => Event, (event) => event.attendantList, {
    onDelete: 'CASCADE',
  })
  @JoinColumn({ name: 'eventNo' })
  event: Event;
}

export default EventAttendant;
