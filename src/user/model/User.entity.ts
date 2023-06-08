import { Column, Entity, PrimaryGeneratedColumn } from 'typeorm';

@Entity({
  name: 't_user',
})
class User {
  @PrimaryGeneratedColumn()
  userNo: number;

  @Column({
    length: 100,
    nullable: false,
  })
  name: string;

  @Column({
    length: 200,
    nullable: false,
    unique: true,
  })
  email: string;
}

export default User;
