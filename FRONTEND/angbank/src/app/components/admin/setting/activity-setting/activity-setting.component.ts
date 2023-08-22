import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
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
  formModel: FormGroup
  
  constructor(
    private activatedRoute: ActivatedRoute,
    private typeActivitiesService: TypeActivitiesService
  ) 

  {
    this.formModel= new FormGroup({
      description: new FormControl('', [
        Validators.required
      ])
    }, [])
  }

  ngOnInit(): void {
    this.activatedRoute.params.subscribe(async(params: any) => {
      let response = await this.typeActivitiesService.getAll();
      if(response.error){
      }   
      this.typeActivities = response;
    })
  }

  getDataForm(){
    if (this.formModel.valid) {
    } else {
      alert('el formulario no esta bien relleno')
    }
  }

  checkControl(pControlName: string, pError: string): boolean {
    if (this.formModel.get(pControlName)?.hasError(pError) && this.formModel.get(pControlName)?.touched) {
      return true;
    } else {
      return false;
    }
  }

}
