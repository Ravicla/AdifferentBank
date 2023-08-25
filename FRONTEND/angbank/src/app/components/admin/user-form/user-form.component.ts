import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Rol } from 'src/app/interfaces/rol.interface';
import { User } from 'src/app/interfaces/user.interface';
import { RolesService } from 'src/app/services/roles.service';
import { UsersService } from 'src/app/services/users.service';
@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.css']
})

export class UserFormComponent implements OnInit{
  user: User | any;
  roles: Rol | any;
  userForm: FormGroup;
  type: string = "Create";

  constructor(
    private activatedRoute: ActivatedRoute,
    private rolesService: RolesService,
    private usersService: UsersService,
    private router: Router
  ){
    this.userForm = new FormGroup({
      //los datos se cogen del formControlName 
      identificationNumber: new FormControl('', [
        //Validators.required
      ]),
      firstName: new FormControl('', [
        //Validators.required,
        //Validators.minLength(3)
      ]),
      lastName: new FormControl('', [
        //Validators.required
      ]),
      birthdate: new FormControl('', [
        //Validators.required
      ]),
      emailAddress: new FormControl('', [
        //Validators.required
        //Validators.pattern(/^[\w-.]+@([\w-]+\.)+[\w-]{2,4}$/)
      ]),
      phoneNumber: new FormControl('', [
        //Validators.required,
        //this.phoneNumberValidator
      ]),
      rol: new FormControl('', [
        //Validators.required
      ]),
      /*roladd: new FormControl('', [
      ])*/
    }, [])
  }
  
  phoneNumberValidator(pControlName: AbstractControl): any {
    const phoneNumber: number = parseInt(pControlName.value)
    if (isNaN(phoneNumber)) {
      return { 'phoneNumbervalidator': 'Lo que introduce no es un numero' }
    } 
    return null
  }

  ngOnInit(): void {
    this.roles = this.rolesService.getAll();

    this.activatedRoute.params.subscribe(async (params: any) => {
      let id: number = parseInt(params.userId);
      if(id) {
        this.type = 'Update'
        const response = await this.usersService.getById(id)
        
        /*En el video y ejercicio esta asi
         const user: User = response.data */
        const user: User = response
        console.log(user);

        this.userForm = new FormGroup({
          identificationNumber: new FormControl(user?.identificationNumber, []),
          firstName: new FormControl(user?.firstName, []),
          lastName: new FormControl(user?.lastName, []),
          birthdate: new FormControl(user?.birthdate, []),
          emailAddress: new FormControl(user?.emailAddress, []),
          phoneNumber: new FormControl(user?.phoneNumber, []),
          rol: new FormControl(user.rol, []),
          /*roladd: new FormControl('', [])*/
          id: new FormControl(user?.userId, [])
        }, [])    
      }    
    })
  }

  /*async getDataForm(): Promise<void> {
    if (this.userForm.valid) {
      let newUser = this.userForm.value;
      newUser.status = true; 
      console.log(newUser)
      newUser.rol = [{ rolId: newUser.rol }];
      try {
        let response = await this.usersService.create(newUser);
        console.log(response);  
        if (response.userId) {
          this.router.navigate(['/users']);
        } 
      } catch (error) {
        console.error(error);
        alert('Error al guardar el usuario');
      }
    } else {
      alert('El formulario no está bien rellenado');
    }
  }*/

  async getDataForm(): Promise<void> {
    if (this.userForm.valid) {
      let newUser = this.userForm.value;
  
      if (newUser.id) {
        // Actualizando usuario existente
        newUser.rol = [{ rolId: newUser.rol }];
        try {
          let response = await this.usersService.update(newUser);
  
          if (response.updatedAt) {
            alert('Usuario actualizado');
            this.router.navigate(['/agenda']);
          }
        } catch (error) {
          console.error(error);
          alert('Error al actualizar el usuario');
        }
      } else {
        // Creando nuevo usuario
        newUser.status = true;
        newUser.rol = [{ rolId: newUser.rol }];
        try {
          let response = await this.usersService.create(newUser);
  
          if (response.id) {
            this.router.navigate(['/agenda']);
          } else {
            alert('Hubo un error al crear el usuario. Inténtelo de nuevo');
          }
        } catch (error) {
          console.error(error);
          alert('Error al guardar el usuario');
        }
      }
    } else {
      alert('El formulario no está bien rellenado');
    }
  }
  

  

 

  checkControl(pControlName: string, pError: string): boolean {
    if (this.userForm.get(pControlName)?.hasError(pError) && this.userForm.get(pControlName)?.touched) {
      return true;
    } else {
      return false;
    }
  }


}
