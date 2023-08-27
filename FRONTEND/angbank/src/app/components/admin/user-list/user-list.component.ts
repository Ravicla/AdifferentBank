import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Rol } from 'src/app/interfaces/rol.interface';
import { User } from 'src/app/interfaces/user.interface';
import { RolesService } from 'src/app/services/roles.service';
import { UsersService } from 'src/app/services/users.service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})

export class UserListComponent implements OnInit{
  
  //users: User | any;
  users: User [] = [];
  
  constructor(
    private activatedRoute: ActivatedRoute,
    private usersService: UsersService,
  ) {}

  ngOnInit(): void {

    this.activatedRoute.params.subscribe(async(params: any) => {
      let response = await this.usersService.getAll();

      if (response && response.length > 0) {
        response.forEach((user: User) => {
          if (user.rol && user.rol.length > 0) {
            const rolDescription = user.rol[0].description;
          } else {
            console.log("No se encontró información de rol para el usuario.");
          }
        });
      } else {
        console.log("No se encontraron usuarios.");
      }

      if(response.error){
      }   
      this.users = response;
    })

  }

  deleteUser(pId: number | undefined): void {
    if (pId !== undefined) {
      this.usersService.delete(pId)
      .then(response => {
        if (response === null) {
          this.users = this.users.filter(user => user.userId !== pId);
          alert('Usuario borrado correctamente');
        }
      })
      .catch(err => console.log(err));
    }
  }
  changeStatus(user: User) {
    user.status = !user.status;
  }


  

}
