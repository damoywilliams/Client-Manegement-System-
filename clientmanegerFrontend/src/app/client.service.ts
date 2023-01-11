import {HttpClient} from'@angular/common/http'
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { environment } from 'src/environments/envirenment';
import { Client } from "./client";   // use to make http request
@Injectable({

    providedIn:'root'


})

export class clientService{
private apiServerUrl=environment.apiBaseUrl

constructor(private http: HttpClient){}      // use to make http request

public getClient(): Observable<Client[]>{  //takes no paramter  return an observable which is a generic and specify the type to any 

    return  this.http.get<Client[]>(`${this.apiServerUrl}/client/all`); //the get request is generic we are going to specify it as any so the return type frop the htpp request is any 
}

public addClient(newclient: Client): Observable<Client>{     // takes a client as parameter   return a client 

    return  this.http.post<Client>(`${this.apiServerUrl}/client/insert`,newclient);     // post request that returns a client  also pass a body newclient with that request  
}

public update(client: Client): Observable<Client>{// dont now retuen anything 

   
    return  this.http.put<Client>(`${this.apiServerUrl}/client/update`,client);  //  empty body becaut put request needs a body even if it is empty 
}


public delete(id: number|null): Observable<void>{

    return  this.http.delete<void>(`${this.apiServerUrl}/client/delete/${id}`);
}



}

