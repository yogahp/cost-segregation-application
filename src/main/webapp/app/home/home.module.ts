import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { CostSegregationApplicationSharedModule } from 'app/shared/shared.module';
import { HOME_ROUTE } from './home.route';
import { HomeComponent } from './home.component';

@NgModule({
  imports: [CostSegregationApplicationSharedModule, RouterModule.forChild([HOME_ROUTE])],
  declarations: [HomeComponent],
})
export class CostSegregationApplicationHomeModule {}
