import { Component, OnInit } from '@angular/core';
import { Client} from './client';
import { clientService } from './client.service';
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  public clients!: Client[];
  public editClient!: Client|null;
  public deleteClient!: Client|null;

  constructor(private clientservice: clientService){}

  ngOnInit() {
    this.getClients();
  }

  public getClients(): void {
    this.clientservice.getClient().subscribe(
      (response: Client[]) => {
      
        this.clients = response;
        console.log(this.clients);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onAddClient(addForm: NgForm): void {
    document.getElementById('add-employee-form')!.click();
    this.clientservice.addClient(addForm.value).subscribe(
      (response: Client) => {
        console.log(response);
        this.getClients();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
  }

  public onUpdateClient(client: Client): void {
    this.clientservice.update(client).subscribe(
      (response:Client) => {
        console.log(response);
        this.getClients();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onDeleteClient(ClientId: number| null): void {
    this.clientservice.delete(ClientId).subscribe(
      (response: void) => {
        console.log(response);
        this.getClients();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public searchclients(key: string): void {
    console.log(key);
    const results: Client[] = [];
    for (const employee of this.clients) {
      var mystring: string=(employee.caseOpen.toString())
      if (employee.firstname.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || employee.lastname.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || employee.email.toLowerCase().indexOf(key.toLowerCase()) !== -1
      ||mystring.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || employee.phoneNumber.toLowerCase().indexOf(key.toLowerCase()) !== -1
      
      || employee.caseDiscription.toLowerCase().indexOf(key.toLowerCase()) !== -1) {
        results.push(employee);
      }
    }
    this.clients = results;
    if (results.length === 0 || !key) {
      this.getClients();
    }
  }

  public onOpenModal(client :Client|null, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addEmployeeModal');
    }
    if (mode === 'edit') {
      this.editClient = client;      //save the edit client so we can use here and in the html 
      button.setAttribute('data-target', '#updateEmployeeModal');
    }
    if (mode === 'delete') {
      this.deleteClient= client;   //save the delete client so we can use here and in the html 
      button.setAttribute('data-target', '#deleteClient\Modal');
    }
    container!.appendChild(button);
    button.click();
  }



}