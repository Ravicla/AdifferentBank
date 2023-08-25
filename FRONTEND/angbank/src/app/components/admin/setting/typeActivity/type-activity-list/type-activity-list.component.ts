import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { TypeActivity } from 'src/app/interfaces/type-activity.interface';
import { TypeActivitiesService } from 'src/app/services/type-activities.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-type-activity-list',
  templateUrl: './type-activity-list.component.html',
  styleUrls: ['./type-activity-list.component.css']
})
export class TypeActivityListComponent implements OnInit{

  typeActivities: TypeActivity [] = [];
  constructor(
    private typeActivitiesService: TypeActivitiesService,
    private activatedRoute: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.activatedRoute.params.subscribe(async(params: any) => {
      let response = await this.typeActivitiesService.getAll();
      if(response.error){
        Swal.fire(response.error, '', 'error');
      }   
      this.typeActivities = response;
      console.log(this.typeActivities);
    })
      
  }

  deleteTypeActivity(pId: number | undefined): void {
    if (pId !== undefined) {
      this.typeActivitiesService.delete(pId)
      .then(response => {
        if (response === null) {
          this.typeActivities = this.typeActivities.filter(typeActivity => typeActivity.typeActivityId !== pId);
          alert('Tipo de actividad borrado correctamente');
        }
      })
      .catch(err => console.log(err));
    }
  }

  

}
