import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{
  formModel: FormGroup
  constructor(){
    this.formModel= new FormGroup({
      //los datos se cogen del formControlName 
      //validdar los correctos correos y cedulas
      emailAddress: new FormControl('', [
        Validators.required,
        Validators.pattern(/^[\w-.]+@([\w-]+\.)+[\w-]{2,4}$/)
      ]),
      identificationNumber: new FormControl('', [
        //Validators.required
      ]),
      
      

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
