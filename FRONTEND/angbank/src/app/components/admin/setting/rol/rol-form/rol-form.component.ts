import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Rol } from 'src/app/interfaces/rol.interface';
import { RolesService } from 'src/app/services/roles.service';

@Component({
  selector: 'app-rol-form',
  templateUrl: './rol-form.component.html',
  styleUrls: ['./rol-form.component.css']
})
export class RolFormComponent implements OnInit{

  rolForm: FormGroup;
  type: string = 'Register';
  
  constructor(
    private rolesServices: RolesService,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ){

    this.rolForm = new FormGroup ({
      description: new FormControl('', [
        Validators.required,
        Validators.minLength(3)
      ])
    }, []);
  }

  
  async getDataForm(): Promise<void> {
    let newRol = this.rolForm.value;
    if (newRol.rolId) {
      //actualizando
      let response = await this.rolesServices.update(newRol);
      if (response.updatedAt) {
        alert('Rol actualizado')
        this.router.navigate(['/roles'])
      }
    } else {
      //creando
      let response = await this.rolesServices.create(newRol)
      console.log(response)
      if (response.rolId) {
        this.router.navigate(['/roles'])
      } else {
        alert('Hubo un error intentelo de nuevo')
      }
    }
  }

  ngOnInit(): void {
    this.activatedRoute.params.subscribe(async(params: any) => {
      let id: number = parseInt(params.rolId);
      if(id){
        this.type = 'Update'
        const response = await this.rolesServices.getById(id)
        const rol: Rol = response
        console.log(rol);

        this.rolForm = new FormGroup({
          description: new FormControl(rol?.description, []), 
          id: new FormControl(rol?.rolId, [])
        }, [])
      }
    })
      
  }

  checkControl(pControlName: string, pError: string): boolean{
    if(this.rolForm.get(pControlName)?.hasError(pError) && this.rolForm.get(pControlName)?.touched){
      return true;
    } 
    else {
      return false;
    }
  }

}
