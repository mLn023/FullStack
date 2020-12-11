import { Bug } from './Bug';
import { Commentary } from './Commentary';

  
export interface Developpeur {
    id?: number;
    name: string;
    firstname: string;
    function: string;
    bugs: Bug[];
    commentaries: Commentary[];
  }