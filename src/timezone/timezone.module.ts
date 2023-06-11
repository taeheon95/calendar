import { Module } from '@nestjs/common';
import { TimezoneController } from './timezone.controller';
import { TimezoneService } from './timezone.service';
import { TypeOrmModule } from '@nestjs/typeorm';
import Timezone from './model/Timezone.entity';

@Module({
  imports: [TypeOrmModule.forFeature([Timezone])],
  controllers: [TimezoneController],
  providers: [TimezoneService],
})
export class TimezoneModule {}
