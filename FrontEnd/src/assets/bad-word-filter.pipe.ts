import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'badWordFilter'
})
export class BadWordFilterPipe implements PipeTransform {

  badWords = ["fuck", "hell", "shit","fuck you","stfu","crap","idiot","stupid","pussy","virgin","burn in hell","damn you ","damn you to hell","motherfucker","bitch","dick","cum","dumb","hoe","hooker"];

  transform(value: string, replaceChar: string = '*'): string {
    if (!value) {
      return value;
    }

    // Split the input string into an array of words
    const words = value.split(' ');

    // Replace bad words with asterisks
    const filteredWords = words.map(word => {
      if (this.badWords.includes(word.toLowerCase())) {
        return replaceChar.repeat(word.length);
      }
      return word;
    });

    // Join the filtered words back into a string
    return filteredWords.join(' ');
  }

}