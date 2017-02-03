#!/usr/bin/perl
use CGI;

{
  package DataStructure;
  sub new {
      my $class = shift;
      bless \$class => $class;
  }
}

{
  package Test;
  @ISA = qw(DataStructure);
  sub buildJson {
    my $class = shift;
    my $childId = shift;
    my $result = "{";
    if ($childId eq "child:/300") {
      $result .= "\"result\":";
      $result .= "[";
      $result .= "{\"testId\": \"Math Test 1\", \"grade\": \"80%\"}";
      $result .= ",";
      $result .= "{\"testId\": \"Math Test 2\", \"grade\": \"86%\"}";
      $result .= "]";
    } elsif ($childId eq "child:/301") {
      $result .= "\"result\":";
      $result .= "[";
      $result .= "{\"testId\": \"Spanish Test 1\", \"grade\": \"79%\"}";
      $result .= ",";
      $result .= "{\"testId\": \"Spanish Test 2\", \"grade\": \"90%\"}";
      $result .= "]";
    } else {
      $result .= "\"result\": []";
    }
    $result .= "}";
    return $result;
  }
}

my $test = Test->new;
my $cgi = CGI->new();
my $child = $cgi->param("child");
print "Content-type: text/html\n\n";

print $test->buildJson($child);
print "\n";
