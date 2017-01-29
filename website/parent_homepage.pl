#!/usr/bin/perl

{
  package DataStructure;
  sub new {
      my $class = shift;
      bless \$class => $class;
  }
}

{
  package Teacher;
  @ISA = qw(DataStructure);
  sub teacherId { "teacher:/100" }
  sub name { "Hip Teacher" }
  sub image { "/classroom/photos/letter_A.jpg" }
  sub classrooms { "[\"classroom:/400\" , \"classroom:/401\"]" }
  sub buildJson {
    my $class = shift;
    $result = "{\"teacherId\":\"";
    $result .= $class->teacherId;
    $result .= "\",\"name\":\"";
    $result .= $class->name;
    $result .= "\",\"image\":\"";
    $result .= $class->image;
    $result .= "\",\"classrooms\":";
    $result .= $class->classrooms;
    $result .= "}";
  }
}

{
  package Parent;
  @ISA = qw(DataStructure);
  sub parentId { "parent:/200" }
  sub name { "Tech Savvy Parent" }
  sub children { "[ \"child:/300\", \"child:/301\"]" }
  sub messageHistory { [] }
  sub searchHistory { [] }
  sub image { "/classroom/photos/letter_B.jpg" }
  sub buildJson {
    my $class = shift;
    $result = "{\"parentId\":\"";
    $result .= $class->parentId;
    $result .= "\",\"name\":\"";
    $result .= $class->name;
    $result .= "\",\"image\":\"";
    $result .= $class->image;
    $result .= "\",\"children\":";
    $result .= $class->children;
    $result .= "}";
  }
}

{
  package Child1;
  @ISA = qw(DataStructure);
  sub childId { "child:/300" }
  sub name { "First Born" }
  sub parent { "parent:/200" }
  sub tests { [] }
  sub quizzes {[]}
  sub classrooms { "[\"classroom:/400\"]"}
  sub image { "/classroom/photos/letter_C.jpg" }
  sub buildJson {
    my $class = shift;
    $result = "{\"childId\":\"";
    $result .= $class->childId;
    $result .= "\",\"name\":\"";
    $result .= $class->name;
    $result .= "\",\"image\":\"";
    $result .= $class->image;
    $result .= "\",\"parent\": \"";
    $result .= $class->parent;
    $result .= "\",\"classrooms\":";
    $result .= $class->classrooms;
    $result .= "}";
  }
}

{
  package Child2;
  @ISA = qw(DataStructure);
  sub childId { "child:/301" }
  sub name { "Second Born" }
  sub parent { "parent:/200" }
  sub tests { [] }
  sub quizzes { [] }
  sub classrooms { "[\"classroom:/401\"]"}
  sub image { "/classroom/photos/letter_D.jpg" }
  sub buildJson {
    my $class = shift;
    $result = "{\"childId\":\"";
    $result .= $class->childId;
    $result .= "\",\"name\":\"";
    $result .= $class->name;
    $result .= "\",\"image\":\"";
    $result .= $class->image;
    $result .= "\",\"parent\": \"";
    $result .= $class->parent;
    $result .= "\",\"classrooms\":";
    $result .= $class->classrooms;
    $result .= "}";
  }
}

{
  package Classroom1;
  @ISA = qw(DataStructure);
  sub classId { "classroom:/400" }
  sub name { "Math Class" }
  sub teacher { "teacher:/100" }
  sub school { "Public System School" }
  sub children { "[\"child:/300\"]"}
  sub tests { [] }
  sub quizzes { [] }
  sub buildJson {
    my $class = shift;
    $result = "{\"classId\":\"";
    $result .= $class->classId;
    $result .= "\",\"name\":\"";
    $result .= $class->name;
    $result .= "\",\"teacher\":\"";
    $result .= $class->teacher;
    $result .= "\",\"school\": \"";
    $result .= $class->school;
    $result .= "\",\"children\":";
    $result .= $class->children;
    $result .= "}";
  }
}

{
  package Classroom2;
  @ISA = qw(DataStructure);
  sub classId { "classroom:/401" }
  sub name { "Spanish Class" }
  sub teacher { "teacher:/100" }
  sub school { "Public System School" }
  sub children { "[\"child:/301\"]" }
  sub tests { [] }
  sub quizzes { [] }
  sub buildJson {
    my $class = shift;
    $result = "{\"classId\":\"";
    $result .= $class->classId;
    $result .= "\",\"name\":\"";
    $result .= $class->name;
    $result .= "\",\"teacher\":\"";
    $result .= $class->teacher;
    $result .= "\",\"school\": \"";
    $result .= $class->school;
    $result .= "\",\"children\":";
    $result .= $class->children;
    $result .= "}";
  }
}

my $parent = Parent->new;
my $teacher = Teacher->new;
my $child1 = Child1->new;
my $child2 = Child2->new;
my $class1 = Classroom1->new;
my $class2 = Classroom2->new;

print "Content-type: text/html\n\n";
print "{\"success\":true,\"teacher\":";
print $teacher->buildJson();
print ",\n\"parent\":";
print $parent->buildJson();
print ",\n\"children\": [";
print $child1->buildJson();
print ",";
print $child2->buildJson();
print "]";
print ",\n\"classrooms\": [";
print $class1->buildJson();
print ",";
print $class2->buildJson();
print "]";
print "}";
print "\n";
