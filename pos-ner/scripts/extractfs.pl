#!/usr/bin/perl -w 

while(<>) {
  next if /^\s*#/;
  chomp;
  if (/^\s*$/) {print "$_\n";next;}
  my @vals=split("\t",$_);
  die "Wrong input format: $_\n" if not @vals==2;

  my $gold=$vals[1];
  my $tok=$vals[0];
  my $l=length($tok);
  my $hasdigit=0;

  $hasdigit=1 if $tok=~/\d/;
  my $hasdot=0;

  $hasdot=1 if $tok=~/\./;

  my $startscap=0;
  $startscap=1 if $tok=~/^[A-Z]/;

  print "$tok\t$l\t$hasdigit\t$hasdot\t$startscap\t$gold\n";
}
