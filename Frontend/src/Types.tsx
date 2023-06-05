export enum Role {
    Admin = 'Admin',
    Pharmacist = 'Pharmacist',
    Personnel = 'Personnel',
  }
  
export interface User {
    username: string;
    role: Role;
    section: Section;
  }

export interface Section {
    id: number;
    name: string;
}

export interface Medicine {
    id: number;
    name: string;
  }

export interface Order {
    id: number;
    createdBy: string;
    date: Date;
    quantity: number;
    medicine: Medicine;
    section: Section;
}