import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-activity-form',
  templateUrl: './activity-form.component.html',
  styleUrls: ['./activity-form.component.css']
})
export class ActivityFormComponent implements OnInit{
  formModel: FormGroup
  constructor(){
    this.formModel= new FormGroup({
      //los datos se cogen del formControlName 
      fullName: new FormControl('', [
        //Validators.required
      ]),
      activity: new FormControl('', [
        //Validators.required,
      ]),
      cost: new FormControl('', [
        //Validators.required
        this.costValidator
      ]),
      description: new FormControl('', [
        //Validators.required
      ]),
      activityDate: new FormControl('', [
        //Validators.required
      ]),
    }, [])
  }

  costValidator(pControlName: AbstractControl): any {
    const cost: number = parseInt(pControlName.value)
    if (isNaN(cost)) {
      return { 'costvalidator': 'El valor introducido no es un numero' }
    } else if (cost < 1 || cost > 2) {
      return { 'costvalidator': 'El valor es de 1 o 2' }
    }
    return null
  }


  ngOnInit(): void {
  }

  getDataForm(){
    if (this.formModel.valid) {
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
