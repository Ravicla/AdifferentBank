import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { TypeActivity } from 'src/app/interfaces/type-activity.interface';
import { TypeActivitiesService } from 'src/app/services/type-activities.service';

@Component({
  selector: 'app-activity-setting',
  templateUrl: './activity-setting.component.html',
  styleUrls: ['./activity-setting.component.css']
})

export class ActivitySettingComponent implements OnInit{

  typeActivities: TypeActivity | any;

  constructor(
    private activatedRoute: ActivatedRoute,
    private typeActivitiesService: TypeActivitiesService
  ) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe(async(params: any) => {
      let response = await this.typeActivitiesService.getAll();
      if(response.error){
      }   
      this.typeActivities = response;
      console.log(this.typeActivities);
    })
  }

}
