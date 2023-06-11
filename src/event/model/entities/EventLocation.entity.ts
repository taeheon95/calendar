import { Column } from 'typeorm';

class EventLocation {
  @Column()
  name: string;
  @Column()
  address: string;
  @Column({
    type: 'double precision',
  })
  latitude?: number;
  @Column({
    type: 'double precision',
  })
  longitude?: number;
}

export default EventLocation;
