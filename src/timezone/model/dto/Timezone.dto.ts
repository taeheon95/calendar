import * as Joi from 'joi';

export interface CreateTimezoneDto {
  timezone: string;
  description: string;
  offset: number;
}

export interface UpdateTimezoneDto {
  timezone: string;
  description: string;
  offset: number;
}

const createTimezoneSchema = Joi.object({
  timezone: Joi.string().required(),
  description: Joi.string().required(),
  offset: Joi.number().min(-12).max(12).required(),
});

const updateTimezoneSchema = Joi.object({
  timezoneNo: Joi.number().required(),
  timezone: Joi.string().required(),
  description: Joi.string().required(),
  offset: Joi.number().min(-12).max(12).required(),
});

export { createTimezoneSchema, updateTimezoneSchema };
