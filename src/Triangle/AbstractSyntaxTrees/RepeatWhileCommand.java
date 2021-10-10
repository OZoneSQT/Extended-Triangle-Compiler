package Triangle.AbstractSyntaxTrees;

/*

ITCR- IC-5701 - Proyecto 1

Modificaciones realizadas

Autores:
Eric Alpizar y Jacob Picado

Descripción:

Nueva estructura de datos para el AST de RepeatWhileCommand

Ultima fecha de modificación:

28/09/2021

 */

import Triangle.SyntacticAnalyzer.SourcePosition;

public class RepeatWhileCommand extends Command {
    public RepeatWhileCommand(Expression eAST_while, Command cAST_while, SourcePosition thePosition) {
        super(thePosition);
        E = eAST_while;
        C = cAST_while;

    }

    @Override
    public Object visit(Visitor v, Object o) { return v.visitRepeatWhileCommand(this, o); }

    public Expression E;
    public Command C;
}
