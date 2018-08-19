import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-page-not-found',
  template: '<img src="assets/not-found.png" alt="That\'s an error. 404 - Not Found." class="center">',
  styles: [`
      .center {
        display: block;
        margin-left: auto;
        margin-right: auto;
        width: 50%;
    }
  `]
})
export class PageNotFoundComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
