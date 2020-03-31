package com.example.twowayelection.service;

import com.example.twowayelection.entity.CourseAndDerection;
import com.example.twowayelection.entity.Judge;
import com.example.twowayelection.entity.Student;
import com.example.twowayelection.entity.Teacher;
import com.example.twowayelection.repository.CourseRepository;
import com.example.twowayelection.repository.JudgeRepository;
import com.example.twowayelection.repository.StudentRepository;
import com.example.twowayelection.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProjectService {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    TeacherRepository teacherRepository;
    @Autowired
    JudgeRepository judgeRepository;
    @Autowired
    CourseRepository courseRepository;
    public void addStudent(Student student){
        studentRepository.save(student);
    }
    public void addTeacher(Teacher teacher){
        teacherRepository.save(teacher);
    }
    public void addJudge(Judge judge){
        judgeRepository.save(judge);
    }
    public void addCourse(CourseAndDerection course){
        courseRepository.save(course);
    }
    public Student getStudent(int id){
        return studentRepository.findById(id).orElse(null);
    }
    public CourseAndDerection getCourse(int id){
        return courseRepository.findById(id).orElse(null);
    }
    public Judge getJudge(int id){
        return judgeRepository.findById(id).orElse(null);
    }
    public Teacher getTeacher(int id){
        return teacherRepository.findById(id).orElse(null);
    }
    public void setAverageGrade(Integer stuID){
        Integer i = 1;
        Integer j = 0;
        Integer flag = 0;
        Double ans=0.0;
        Double ans1 =0.0;
        while (true){
            if(getJudge(i).getStudent().getStuID()==stuID){
                if(getJudge(i).getGrade()>=getJudge(i).getCourse().getGradeLimit()){
                    flag = 1;
                }
                else {flag = 0;}
            }
            i++;
            if(getJudge(i)==null){
              List<Judge> judges = judgeRepository.list1(stuID);
              if(flag==1){
              for(j=0;j<judges.size();j++){
                  Double g = judges.get(j).getGrade();
                  g = g*(judges.get(j).getCourse().getWeight());
                  Double g1 = judges.get(j).getCourse().getWeight();
                  ans =ans+g;
                  ans1=ans1+g1;
              }
              }
                break;
            }
        }
       if(flag==1) getStudent(stuID).setAverageGrade(ans/ans1);
       else getStudent(stuID).setAverageGrade(null);
    }
    public void setQualifiedNumber(int tid){
        int i=0;
        int j=1;
        while (true){
            if(getStudent(j).getAverageGrade()!=null){
                i++;
            }
            j++;
            if(getStudent(j)==null)break;
        }
        getTeacher(tid).setQualifiedNumber(i);
    }
    public  Double[] bubbleSort(Double[] grades) {
        if (grades.length == 0)
            return grades;
        for (int i = 0; i < grades.length; i++)
            for (int j = 0; j < grades.length - 1 - i; j++)
                if (grades[j + 1] < grades[j]) {
                    double temp = grades[j + 1];
                    grades[j + 1] = grades[j];
                    grades[j] = temp;
                }
        return grades;
    }
    public List<Student> setQualifiedStudent(int tid){
        Integer k=1,tmp=0;
        Double[] grades = new Double[200];
        List<Student> students = new ArrayList();
        while(true){
            if (getStudent(k).getAverageGrade() != null) {
                grades[tmp] = getStudent(k).getAverageGrade();
                tmp++;
            }
            k++;
            if(getStudent(k)==null)break;
        }
        for (int i = 0; i < tmp; i++) {
            for (int j = 0; j < tmp-1 - i; j++)
                if (grades[j + 1] < grades[j]) {
                    double temp = grades[j + 1];
                    grades[j + 1] = grades[j];
                    grades[j] = temp;
                }
        }
        int sum = getTeacher(tid).getTotalNumber();
        if(tmp<=sum)sum=tmp;
        for (k=0;k<sum;k++){
            for(int j=1;j<=sum;j++){
                if(getStudent(j).getAverageGrade()==grades[k]){
                    students.add(getStudent(j));
                    break;
                }
            }
        }
        return students;
    }
}
