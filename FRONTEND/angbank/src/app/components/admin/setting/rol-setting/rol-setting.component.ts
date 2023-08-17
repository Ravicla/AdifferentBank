import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
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
  formModel: FormGroup

  constructor(
    private activatedRoute: ActivatedRoute,
    private rolesService: RolesService
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
      let response = await this.rolesService.getAll();
      if(response.error){
      }   
      this.roles = response;
    })
  }

  getDataForm(){
    if (this.formModel.valid) {
      console.log(this.formModel.value)
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
