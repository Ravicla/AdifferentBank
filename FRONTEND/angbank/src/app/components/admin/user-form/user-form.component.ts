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
  userForm: FormGroup

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
  }

  async getDataForm(): Promise<void> {
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
  }

  

 

  checkControl(pControlName: string, pError: string): boolean {
    if (this.userForm.get(pControlName)?.hasError(pError) && this.userForm.get(pControlName)?.touched) {
      return true;
    } else {
      return false;
    }
  }


}
