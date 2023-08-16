import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Rol } from 'src/app/interfaces/rol.interface';
import { RolesService } from 'src/app/services/roles.service';

@Component({
  selector: 'app-rol-setting',
  templateUrl: './rol-setting.component.html',
  styleUrls: ['./rol-setting.component.css']
})
export class RolSettingComponent implements OnInit{
  roles: Rol | any;

  constructor(
    private activatedRoute: ActivatedRoute,
    private rolesService: RolesService
  ) {}

  ngOnInit(): void {
      this.activatedRoute.params.subscribe(async(params: any) => {
      let response = await this.rolesService.getAll();
      if(response.error){
      }   
      this.roles = response;
    })
  }

}
