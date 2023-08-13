import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormControl, FormGroup, Validators } from '@angular/forms';
@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.css']
})
export class UserFormComponent implements OnInit{

  formModel: FormGroup
  constructor(){
    this.formModel= new FormGroup({
      //los datos se cogen del formControlName 
      identificationNumber: new FormControl('', [
        Validators.required
      ]),
      firstName: new FormControl('', [
        Validators.required,
        Validators.minLength(3)
      ]),
      lastName: new FormControl('', [
        //Validators.required
      ]),
      birthdate: new FormControl('', [
        //Validators.required
      ]),
      emailAddress: new FormControl('', [
        //Validators.required
        Validators.pattern(/^[\w-.]+@([\w-]+\.)+[\w-]{2,4}$/)
      ]),
      phoneNumber: new FormControl('', [
        Validators.required,
        this.phoneNumberValidator
      ]),
      rol: new FormControl('', [
        //Validators.required
      ])

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
