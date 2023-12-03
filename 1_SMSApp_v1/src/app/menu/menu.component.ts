import { Component, ViewChild } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { UserService } from '../service/user.service';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import {MatSidenav, MatSidenavModule} from '@angular/material/sidenav';


@Component({
  selector: 'app-menu',
  standalone: true,
  imports: [CommonModule, RouterModule,MatToolbarModule,MatIconModule,MatSidenavModule],
  templateUrl: './menu.component.html',
  styleUrl: './menu.component.css'
})
export class MenuComponent {
  @ViewChild('s') sidenav!: MatSidenav;
  constructor(public service:UserService) {}
  toggleSidebar() {
    this.sidenav.toggle();
  }
}
