import { Injectable } from '@nestjs/common';
import { InjectRepository } from '@nestjs/typeorm';
import { Repository } from 'typeorm';
import Timezone from './model/Timezone.entity';
import { CreateTimezoneDto, UpdateTimezoneDto } from './model/dto/Timezone.dto';

@Injectable()
export class TimezoneService {
  constructor(
    @InjectRepository(Timezone)
    private readonly timezoneRepository: Repository<Timezone>,
  ) {}

  async getTimezoneList() {
    return await this.timezoneRepository.find();
  }

  async getTimezone(id: number) {
    return await this.timezoneRepository.findOne({
      where: {
        timezoneNo: id,
      },
    });
  }

  async create(createTimezoneDto: CreateTimezoneDto) {
    return await this.timezoneRepository.save(
      Timezone.createTimezone(createTimezoneDto),
    );
  }

  async update(id: number, updateTimezoneDto: UpdateTimezoneDto) {
    const timezone: Timezone = await this.timezoneRepository.findOneOrFail({
      where: {
        timezoneNo: id,
      },
    });
    timezone.update(updateTimezoneDto);
    return await this.timezoneRepository.save(timezone);
  }

  async delete(id: number) {
    return await this.timezoneRepository.delete(id);
  }
}
