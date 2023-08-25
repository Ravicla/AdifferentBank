import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Rol } from 'src/app/interfaces/rol.interface';
import { RolesService } from 'src/app/services/roles.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-rol-list',
  templateUrl: './rol-list.component.html',
  styleUrls: ['./rol-list.component.css']
})
export class RolListComponent implements OnInit{

  roles: Rol [] = [];
  constructor(
    private rolesService: RolesService,
    private activatedRoute: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.activatedRoute.params.subscribe(async(params: any) => {
      let response = await this.rolesService.getAll();
      if(response.error){
        Swal.fire(response.error, '', 'error');
      }   
      this.roles = response;
      console.log(this.roles);
    })
      
  }

 

  deleteRol(pId: number | undefined): void {
    if (pId !== undefined) {
      this.rolesService.delete(pId)
      .then(response => {
        if (response === null) {
          this.roles = this.roles.filter(rol => rol.rolId !== pId);
          alert('Rol borrado correctamente');
        }
      })
      .catch(err => console.log(err));
    }     
  } 
}
