import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute,Router } from '@angular/router';
import { Rol } from 'src/app/interfaces/rol.interface';
import { User } from 'src/app/interfaces/user.interface';
import { RolesService } from 'src/app/services/roles.service';
import { UsersService } from 'src/app/services/users.service';
import * as $ from 'jquery';
import 'datatables.net';

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
    private router: Router
  ) {}

  ngOnInit(): void {
    this.loadData();
  }

  async loadData() {
    try {
      const response = await this.usersService.getAll();
      this.users = response;

      if (this.users.length > 0) {
        this.initDataTable();
      } else {
        console.log("No se encontraron usuarios.");
      }
    } catch (error) {
      console.error("Error al cargar usuarios:", error);
    }
  }

  initDataTable() {
    const self = this;
    $('#dataTable').DataTable({
      searching: true,
      data: this.users,
      columns: [
        { title: 'Número de Identificación', data: 'identificationNumber' },
        {
          title: 'Nombre y Apellido',
          data: null,
          render: function (data, type, row) {
            return data.firstName + ' ' + data.lastName;
          }
        },
        {
          title: 'Roles',
          data: null,
          render: (data, type, row: User) => {
            if (row.rol && row.rol.length > 0) {
              const rolDescriptions = row.rol.map(rol => rol.description).join(', ');
              return rolDescriptions;
            } else {
              return "Sin roles";
            }
          }
        },
        {
          title: 'Estado',
          data: null,
          render: (data, type, row: User) => {
            return `
              <button class="btn btn-sm status-btn ${row.status ? 'btn-light' : 'btn-danger'}"
                      (click)="changeStatus(${JSON.stringify(row)})">
                ${row.status ? 'Activo' : 'Inactivo'}
              </button>`;
          }
        },
        {
          title: 'Acción',
          data: null,
          render: (data, type, row: User) => {
            const userId = row.userId;
            const buttonsHtml = `
              <button class="btn btn-sm view-btn" data-user-id="${userId}">
                <i class="fas fa-fw fa-eye"></i><br>
              </button>
              <button class="btn btn-sm update-btn" data-user-id="${userId}">
                <i class="fa-solid fa-pen-to-square"></i><br>
              </button>
              <button class="btn btn-sm delete-btn" data-user-id="${userId}">
                <i class="fas fa-fw fa-trash"></i><br>
              </button>`;
            return buttonsHtml;
          }
        }
      ]
    });

    $('#dataTable').on('click', '.view-btn', function() {
      const userId = $(this).data('user-id');
      self.navigateToUserDetail(userId);
    });
  
    $('#dataTable').on('click', '.update-btn', function() {
      const userId = $(this).data('user-id');
      self.navigateToUpdateUser(userId);
    });
  
    $('#dataTable').on('click', '.delete-btn', function() {
      const userId = $(this).data('user-id');
      self.deleteUser(userId);
    });

    $('#dataTable').on('click', '.status-btn', function() {
      const userId = $(this).data('user-id');
      self.changeStatus(userId);
    });
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
  
  navigateToUserDetail(userId: number) {
    this.router.navigate(['/user', userId]);
  }
  navigateToUpdateUser(userId: number) {
    this.router.navigate(['/updateUser', userId]);
  }
  
  changeStatus(user: User) {
    console.log(user)
    user.status = !user.status;
  }

  ngOnDestroy(): void {
    // Destruye la instancia de DataTables
    $('#dataTable').DataTable().destroy();
  }
  

}
