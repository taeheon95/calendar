import {
  Controller,
  Post,
  Body,
  UsePipes,
  Get,
  Param,
  Put,
  Delete,
  ParseIntPipe,
} from '@nestjs/common';
import {
  CreateTimezoneDto,
  UpdateTimezoneDto,
  createTimezoneSchema,
  updateTimezoneSchema,
} from './model/dto/Timezone.dto';
import { JoiValidation } from '../util/JoiValidation.pipe';
import { TimezoneService } from './timezone.service';

@Controller('timezone')
export class TimezoneController {
  constructor(private readonly timezoneService: TimezoneService) {}

  @Get()
  async getTimezoneList() {
    return await this.timezoneService.getTimezoneList();
  }

  @Get(':id')
  async getTimezone(@Param('id') id: number) {
    return await this.timezoneService.getTimezone(id);
  }

  @Post()
  @UsePipes(new JoiValidation(createTimezoneSchema))
  async create(@Body() createTimezoneDto: CreateTimezoneDto) {
    return await this.timezoneService.create(createTimezoneDto);
  }

  @Put(':id')
  @UsePipes(new JoiValidation(updateTimezoneSchema))
  async update(
    @Param('id', ParseIntPipe) id: number,
    @Body() updateTimezoneDto: UpdateTimezoneDto,
  ) {
    return await this.timezoneService.update(id, updateTimezoneDto);
  }

  @Delete(':id')
  async delete(@Param('id', ParseIntPipe) id: number) {
    return await this.timezoneService.delete(id);
  }
}
