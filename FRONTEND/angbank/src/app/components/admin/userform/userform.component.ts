import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormControl, FormGroup, Validators } from '@angular/forms';


@Component({
  selector: 'app-userform',
  templateUrl: './userform.component.html',
  styleUrls: ['./userform.component.css']
})
export class UserformComponent implements OnInit{

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
      lastName: new FormControl('', []),
      birthdate: new FormControl('', []),
      emailAddress: new FormControl('', []),
      phoneNumber: new FormControl('', []),
      rol: new FormControl('', [])

    }, [])
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
