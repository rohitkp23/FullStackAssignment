import { Component } from "@angular/core";
import { UserService } from "../service/user.service";
import { CommonModule } from "@angular/common";


@Component({
    templateUrl:'./header.component.html',
    styleUrls:['./header.component.css'],
    imports: [CommonModule],
    selector:'app-header',
    standalone:true
})

class HeaderComponent{
    message:string="Student Management App"

    constructor(public service:UserService) {
    
    }
}
export default HeaderComponent;