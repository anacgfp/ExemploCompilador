# ExemploCompilador
 --mini projeto da disciplina de compiladores
 
 É uma linguagem de domínio específico que simplifica o desenho de formas geométricas do java.awt
 
 Exemplo de entrada: draw square -side= 2 blue 79 98
 
 Gramática:
 
 programa
= _ d1: desenho _ s: programa _ {return factory.criaNo("programa", [d1,s]);} 
/_ d1:desenho _ { return factory.criaNo("programa", [d1]);} 

desenho
= _ "draw" _ s:shape _ {return factory.criaNo("draw", [s]);}

shape =
_ "square" _ "-side=" _ len: int _ c:color _ x:int _ y:int _ {return factory.criaNo("square", [len,c,x,y]);}
/ _ "circle" _ "-radius=" _ r: int _ c:color _ x:int _ y:int _ {return factory.criaNo("circle",[r,c,x,y]);}
/_"line"_ "-p1="_ p1: point _ "-p2=" _ p2: point _ c:color _ {return factory.criaNo("line",[p1,p2,c]);}
/ _ "triangle" _ "-p1=" _ p1: point _ "-p2=" _ p2:point _ "-p3=" _ p3:point _ c:color _ {return factory.criaNo("triangle",[p1,p2,p3,c]);}
/ _ "rectangle" _ "-a=" _ a:int _ "-b=" _ b:int _ c:color _ x:int _ y:int _ {return factory.criaNo("rectangle",[a,b,c,x,y]);}
/_ "ellipse" _ "-a=" _ a:int _ "-b=" _ b:int _ c:color _ x:int _ y:int _ {return factory.criaNo("ellipse", [a,b,c,x,y]);}


color
=
_ [a-z]+ _ { return text();}

point
  = _ x:int _","_ y:int _ { return factory.criaNo("point",[x,y]); }


int
  = _ [0-9]+ { return parseFloat(text(), 10); }

_ "whitespace"
  = [ \t\n\r]*
