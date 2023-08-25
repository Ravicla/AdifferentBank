import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { TypeActivity } from 'src/app/interfaces/type-activity.interface';
import { TypeActivitiesService } from 'src/app/services/type-activities.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-type-activity-form',
  templateUrl: './type-activity-form.component.html',
  styleUrls: ['./type-activity-form.component.css']
})
export class TypeActivityFormComponent implements OnInit{

  typeActivityForm: FormGroup;
  type: string = 'Register';
  
  constructor(
    private typeActivitiesServices: TypeActivitiesService,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ){

    this.typeActivityForm = new FormGroup ({
      activity: new FormControl('', [
        Validators.required,
        Validators.minLength(3)
      ])
    }, []);
  }

  
  async getDataForm(): Promise<void> {
    let newTypeActivity = this.typeActivityForm.value;
    if (newTypeActivity.typeActivityId) {
      //actualizando
      let response = await this.typeActivitiesServices.update(newTypeActivity);

      if (response.updatedAt) {
        alert('Type Activity actualizado')
        this.router.navigate(['/typeActivities'])
      }
    } else {
      //creando
      let response = await this.typeActivitiesServices.create(newTypeActivity)
      console.log(response)
      if (response.typeActivityId) {
        this.router.navigate(['/typeActivities'])
      } else {
        alert('Hubo un error intentelo de nuevo')
      }
    }
  }

  ngOnInit(): void {
    this.activatedRoute.params.subscribe(async(params: any) => {
      let id: number = parseInt(params.typeActivityId);
      if(id){
        this.type = 'Update'
        const response = await this.typeActivitiesServices.getById(id)
        const typeActivity: TypeActivity = response
        console.log(typeActivity);

        this.typeActivityForm = new FormGroup({
          activity: new FormControl(typeActivity?.activity, []), 
          id: new FormControl(typeActivity?.typeActivityId, [])
        }, [])
      }
    })
      
  }

  checkControl(pControlName: string, pError: string): boolean{
    if(this.typeActivityForm.get(pControlName)?.hasError(pError) && this.typeActivityForm.get(pControlName)?.touched){
      return true;
    } 
    else {
      return false;
    }
  }

}
