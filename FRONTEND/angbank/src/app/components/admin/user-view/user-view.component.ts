import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { User } from 'src/app/interfaces/user.interface';
import { UsersService } from 'src/app/services/users.service';

@Component({
  selector: 'app-user-view',
  templateUrl: './user-view.component.html',
  styleUrls: ['./user-view.component.css']
})
export class UserViewComponent implements OnInit{

  user!: User;
  constructor(
    private activatedRoute: ActivatedRoute,
    private usersService: UsersService
  ) {}
  
  ngOnInit(): void {
    this.activatedRoute.params.subscribe(async (params: any) => {
      const userId = params['iduser'];
      this.user = await this.usersService. getById(userId); // Cambiar a la función que obtiene un usuario por ID
    });
  }


  changeStatus(user: User) {
    user.status = !user.status;
  }

}


