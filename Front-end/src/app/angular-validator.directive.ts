import { Directive, Input } from "@angular/core";
import { NG_VALIDATORS, Validators, Validator, AbstractControl } from '@angular/forms';

@Directive({
    selector: '[compare]',
    providers: [{
        provide : NG_VALIDATORS,
        useExisting : ConfirmEqualValidatorDirective,
        multi : true
    }]
})

export class ConfirmEqualValidatorDirective implements Validator{
    @Input('compare') appConfigEqualValidator : string
    validate(control: AbstractControl): {[key:string]:any} | null{
        const controlToCompare = control.parent.get(this.appConfigEqualValidator);
        console.log(controlToCompare);
        if(controlToCompare&&controlToCompare.value!== control.value){
            return {'notEqual' : true}
        }

        return null;
    }
}
