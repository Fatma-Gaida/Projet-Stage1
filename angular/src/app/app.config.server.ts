import { mergeApplicationConfig, ApplicationConfig } from '@angular/core';
import { provideServerRendering } from '@angular/platform-server';
import { appConfig } from './app.config';
import { EmployeeService } from './employees/employees.service';

const serverConfig: ApplicationConfig = {
  providers: [
    provideServerRendering(),EmployeeService
  ]
};

export const config = mergeApplicationConfig(appConfig, serverConfig);
