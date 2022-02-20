using System;
using System.IO;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Kursova_Rl_
{
    public partial class FrmTest : Form
    {
        int zvuk = 0;
        public static string DataZvuk = "Data\\Tema\\";
        string PIB;
        public static string scoretest;
        public static int countForm = 0;
        public static string test;
        List<string> strMass = new List<string>();
        string[] massQua;
        public string[][] massVar;
        public IEnumerable<string> testQua;
        static int ball = 0;
        int k;
        int i = 0;
        int questionCount = 0;
        string selected;
        public FrmTest()
        {
            countForm = 1;
            InitializeComponent();
        }
        private void FrmTest_Load(object sender, EventArgs e)
        {
            MaximizeBox = false;
            testQua = File.ReadLines(test, Encoding.GetEncoding(1251));
            
            questionCount = testQua.Count();
            massQua = new string[questionCount];
            massVar = new string[questionCount][];
            i = 0;

            foreach (string t in testQua)
            {
                string[] m = t.Split('?');

                massQua[k] = m[0];
                massVar[k] = m[1].Split('@');
                k += 1;
            }

            //завантажуємо перше питання
            loadQuestion(i);
            if (File.Exists(DataZvuk + FrmTEMATEST.lbl + "\\Audio\\" + zvuk + ".mp3"))
            {
                player.URL = DataZvuk + FrmTEMATEST.lbl + "\\Audio\\" + zvuk + ".mp3";
                player.settings.volume = 100;
                player.Ctlcontrols.play();
            }
        }
        private void loadQuestion(int questionId)
        {
            //очистимо виділення
            rb1.Checked = false;
            rb2.Checked = false;
            rb3.Checked = false;
            rb4.Checked = false;

            //показуємо питання і варіанти відповідей
            lblvopros.Text = massQua[questionId];
            rb1.Text = massVar[questionId][1];
            rb2.Text = massVar[questionId][2];
            rb3.Text = massVar[questionId][3];
            rb4.Text = massVar[questionId][4];
        }
        private void btnNext_Click(object sender, EventArgs e)
        {
            zvuk += 1;
            player.Ctlcontrols.stop();

            string selected = null;
            if (rb1.Checked)
            {
                selected = rb1.Text;
            }
            else if (rb2.Checked)
            {
                selected = rb2.Text;
            }
            else if (rb3.Checked)
            {
                selected = rb3.Text;
            }
            else if (rb4.Checked)
            {
                selected = rb4.Text;
            }
            else
            {
                MessageBox.Show("Виберіть варіант відповіді");
                return;
            }

            //якщо відповідь правильна, то додаємо 1 бал
            if (selected != null && selected == massVar[i][0])
            {
                ball += 1;
            }

            //інкрементимо лічильник питань
            i += 1;
            
            //якщо це було останнє питання, то покажемо результат
            if (i == questionCount)
            {
                int v;
                MessageBox.Show("Ваш бал - " + ball.ToString());
                this.Close();
                IEnumerable<string> a = (File.ReadLines("Data\\User\\UserPIB.txt"));
                int i = 0;
                foreach (string str in a)
                {
                    string[] l = str.Split(' ');

                    if (FrmLogin.User == l[0])
                    {
                        PIB = l[1] + " " + l[2];
                    }
                    i++;
                }
                if (File.Exists(scoretest))
                {
                    string Score = PIB + " -- " + FrmTest.ball + Environment.NewLine; ;
                    File.AppendAllText(scoretest, Score);
                }
                ball = 0;
                FrmTEMATEST show = new FrmTEMATEST();
                show.Show();
              
            }
            else
            {
                //завантажуємо наступне питання
                loadQuestion(i);
                player.URL = DataZvuk + FrmTEMATEST.lbl + "\\Audio\\" + zvuk + ".mp3";
                player.settings.volume = 100;
                player.Ctlcontrols.play();
                
            }
        }

      
        private void FrmTest_FormClosing(object sender, FormClosingEventArgs e)
        {
            countForm = 0;
           // this.Close();
        }
    }
}
